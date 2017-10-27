package com.woorea.openstack.cinder;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.ConnectionForInitialize;
import com.woorea.openstack.cinder.model.ConnectionForTerminate;
import com.woorea.openstack.cinder.model.ConnectionInfo;
import com.woorea.openstack.cinder.model.Metadata;
import com.woorea.openstack.cinder.model.Volume;
import com.woorea.openstack.cinder.model.VolumeForCreate;
import com.woorea.openstack.cinder.model.VolumeForExtend;
import com.woorea.openstack.cinder.model.VolumeForImageCreate;
import com.woorea.openstack.cinder.model.VolumeForUpdate;
import com.woorea.openstack.cinder.model.Volumes;

public class VolumesExtension {

    private final OpenStackClient CLIENT;

    public VolumesExtension(OpenStackClient client) {
        CLIENT = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public Create create(VolumeForCreate volume) {
        return new Create(volume);
    }

    public UploadToImage uploadToImage(VolumeForImageCreate volumeForImage) {
        return new UploadToImage(volumeForImage);
    }

    public Show show(String id) {
        return new Show(id);
    }

    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }

    public Delete delete(String id) {
        return new Delete(id);
    }

    public Update update(String id, VolumeForUpdate volume) {
        return new Update(id, volume);
    }

    public Extend extend(String id, int newSize) {
        VolumeForExtend volume = new VolumeForExtend();
        volume.setSize(newSize);
        return new Extend(id, volume);
    }

    public InitializeConnection initializeConnection(String id, ConnectionForInitialize connectionForInitialize) {
        return new InitializeConnection(id, connectionForInitialize);
    }

    public TerminateConnection terminateConnection(String id, ConnectionForTerminate connectionForTerminate) {
        return new TerminateConnection(id, connectionForTerminate);
    }

    public class List extends OpenStackRequest<Volumes> {

        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/volumes/detail"
                    : "/volumes", null, Volumes.class);
        }

    }

    public class Create extends OpenStackRequest<Volume> {

        public Create(VolumeForCreate volume) {
            super(CLIENT, HttpMethod.POST, "/volumes", Entity.json(volume),
                    Volume.class);
        }

    }

    // Upload volume to image service as image

    public class UploadToImage extends OpenStackRequest<Void> {

        public UploadToImage(VolumeForImageCreate volumeForImageCreate) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/volumes/")
                    .append(volumeForImageCreate.getVolumeId() + "/action").toString(),
                    Entity.json(volumeForImageCreate), Void.class);
        }

    }

    public class Show extends OpenStackRequest<Volume> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/volumes/")
                    .append(id).toString(), null, Volume.class);
        }

    }

    public class ShowMetadata extends OpenStackRequest<Metadata> {

        public ShowMetadata(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/volumes/")
                    .append(id).append("/metadata").toString(), null,
                    Metadata.class);
        }

    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/volumes/")
                    .append(id).toString(), null, Void.class);
        }

    }

    public class Update extends OpenStackRequest<Void> {

        public Update(String id, VolumeForUpdate volume) {
            super(CLIENT, HttpMethod.PUT, new StringBuilder("/volumes/").append(id).toString(),
                    Entity.json(volume), Void.class);
        }

    }

    public class Extend extends OpenStackRequest<Void> {

        public Extend(String id, VolumeForExtend volume) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/volumes/").append(id).append("/action").toString(),
                    Entity.json(volume), Void.class);
        }

    }

    public class InitializeConnection extends OpenStackRequest<ConnectionInfo> {

        public InitializeConnection(String id, ConnectionForInitialize connectionForInitialize) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/volumes/")
                    .append(id).append("/action").toString(),
                    Entity.json(connectionForInitialize), ConnectionInfo.class);
        }

    }

    public class TerminateConnection extends OpenStackRequest<Void> {

        public TerminateConnection(String id, ConnectionForTerminate connectionForTerminate) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/volumes/")
                            .append(id).append("/action").toString(),
                    Entity.json(connectionForTerminate), Void.class);
        }

    }

}
