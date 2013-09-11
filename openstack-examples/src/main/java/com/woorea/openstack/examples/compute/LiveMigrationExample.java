public class LiveMigrationExample {

	public Access authenticate(String tenantId) {
		Keystone keystone = new Keystone(
				ExamplesConfiguration.KEYSTONE_AUTH_URL);
		// access with unscoped token
		Access access = keystone
				.tokens()
				.authenticate(
						new UsernamePassword(
								ExamplesConfiguration.KEYSTONE_USERNAME,
								ExamplesConfiguration.KEYSTONE_PASSWORD))
				.withTenantId(tenantId).execute();
		// authorization
		access = keystone
				.tokens()
				.authenticate(
						new TokenAuthentication(access.getToken().getId()))
				.withTenantId(tenantId).execute();
		System.out.println("token" + access.getToken());
		return access;
	}
	public void liveMigration(Access access, String tenantId) {
		System.out.println("in livemigration");
		Nova nova = new Nova(
				ExamplesConfiguration.NOVA_ENDPOINT.concat(tenantId));

		nova.setTokenProvider(new OpenStackSimpleTokenProvider(access
				.getToken().getId()));
		LiveMigrationSet liveMigrationSet = new LiveMigrationSet();
		//provide hostname of the compute node to wich you want to migrate
		liveMigrationSet.setHostName("hostnname");
		//server id of the server , wich you want to migrate
		liveMigrationSet.setServerId("serverId");
		nova.servers().getServerForMigration(liveMigrationSet).execute();
		nova.servers().liveMigration(liveMigrationSet).execute();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LiveMigrationExample example = new LiveMigrationExample();
//provide tenant id to authenticate and server id to migrate
				Access access = example
				.authenticate("tenantId");
		example.liveMigration(access, "serverId");
	}
	}
