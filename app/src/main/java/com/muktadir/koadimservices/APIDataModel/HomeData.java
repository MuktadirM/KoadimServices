package com.muktadir.koadimservices.APIDataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeData{
    private int id;
    private String name;
    private String slug;
    private String home_image_url;
    private boolean is_last_node;
    private List<OptionsArray>options;
    private ImageThumb image_thumb_url;
    private IconThumb icon_thumb_url;
    private List<ServiceTypeInner> service_types;

    public HomeData(int id, String name, String slug, String home_image_url, boolean is_last_node, List<OptionsArray>options, ImageThumb image_thumb_url, IconThumb icon_thumb_url, List<ServiceTypeInner> service_types) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.home_image_url = home_image_url;
        this.is_last_node = is_last_node;
        this.options = options;
        this.image_thumb_url = image_thumb_url;
        this.icon_thumb_url = icon_thumb_url;
        this.service_types = service_types;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getHome_image_url() {
        return home_image_url;
    }

    public boolean isIs_last_node() {
        return is_last_node;
    }

    public List<OptionsArray> getOptions() {
        return options;
    }

    public ImageThumb getImage_thumb_url() {
        return image_thumb_url;
    }

    public IconThumb getIcon_thumb_url() {
        return icon_thumb_url;
    }

    public List<ServiceTypeInner> getService_types() {
        return service_types;
    }
    public class ServiceTypeInner {
        private int id;
        @SerializedName("name")
        private String ServiceName;
        //       slug
        @SerializedName("slug")
        private String ServiceSlug;
        private ImageThumb image_thumb_url;

        public ServiceTypeInner() {
        }
        public ServiceTypeInner(int id, String ServiceName, String slug, ImageThumb image_thumb_url) {
            this.id = id;
            this.ServiceName = ServiceName;
            this.ServiceSlug = slug;
            this.image_thumb_url = image_thumb_url;
        }

        public int getId() {
            return id;
        }

        public String getServiceName() {
            return ServiceName;
        }

        public String getServiceSlug() {
            return ServiceSlug;
        }

        public ImageThumb getImage_thumb_url() {
            return image_thumb_url;
        }
    }
   public class IconThumb extends ImageThumb{
        public IconThumb() {
        }
        public IconThumb(String lg, String md, String sm) {
            super(lg, md, sm);
        }

        @Override
        public String getLg() {
            return super.getLg();
        }

        @Override
        public String getMd() {
            return super.getMd();
        }

        @Override
        public String getSm() {
            return super.getSm();
        }
    }
   public class ImageThumb{
        private String lg;
        private String md;
        private String sm;

        public ImageThumb() {
        }
        public ImageThumb(String lg, String md, String sm) {
            this.lg = lg;
            this.md = md;
            this.sm = sm;
        }

        public String getLg() {
            return lg;
        }

        public String getMd() {
            return md;
        }

        public String getSm() {
            return sm;
        }
    }
   public class OptionsArray{
        private String options;

        public OptionsArray(String options) {
            this.options = options;
        }
        public String getOptions() {
            return options;
        }
    }


}

