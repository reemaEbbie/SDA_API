package pojo.booking;

import java.util.List;

public class UserResponse {
    private List<DataItem> data;
    private Meta meta;

    public void setData(List<DataItem> data){
        this.data = data;
    }

    public List<DataItem> getData(){
        return data;
    }

    public void setMeta(Meta meta){
        this.meta = meta;
    }

    public Meta getMeta(){
        return meta;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "data = '" + data + '\'' +
                        ",meta = '" + meta + '\'' +
                        "}";
    }
}