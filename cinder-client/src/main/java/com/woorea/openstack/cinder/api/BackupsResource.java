package com.woorea.openstack.cinder.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Backup;
import com.woorea.openstack.cinder.model.BackupForCreate;
import com.woorea.openstack.cinder.model.BackupForRestore;
import com.woorea.openstack.cinder.model.Backups;

/**
 * Cinder Backups Management
 *
 * @author VAL Informatique
 */
public class BackupsResource {

    private final OpenStackClient CLIENT;

    public BackupsResource(OpenStackClient client) {
        this.CLIENT = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public Create create(BackupForCreate backupForCreate) {
        return new Create(backupForCreate);
    }

    public Delete delete(String backupId) {
        return new Delete(backupId);
    }

    public Show show(String backupId) {
        return new Show(backupId);
    }

    public Restore restore(String backupId, String volumeId) {
        BackupForRestore lBFR = new BackupForRestore();
        lBFR.setVolumeId(volumeId);
        return new Restore(lBFR, backupId);
    }

    public class List extends OpenStackRequest<Backups> {

        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/backups/detail" : "backups", null, Backups.class);
        }
    }

    public class Create extends OpenStackRequest<Backup> {

        public Create(BackupForCreate backupForCreate) {
            super(CLIENT, HttpMethod.POST, "backups", Entity.json(backupForCreate), Backup.class);
        }
    }

    public class Show extends OpenStackRequest<Backup> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, buildPath("backups/", id), null, Backup.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, buildPath("backups/", id), null, Void.class);
        }
    }

    public class Restore extends OpenStackRequest<Void> {

        public Restore(BackupForRestore backupForRestore, String id) {
            super(CLIENT, HttpMethod.POST, buildPath("backups/", id).concat("/restore"), Entity.json(backupForRestore), Void.class);
        }
    }
}
