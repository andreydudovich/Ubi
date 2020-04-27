package elements.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookModel {

    @SerializedName("name")
    private String name;

    @SerializedName("author")
    private String author;

    @SerializedName("year")
    private String year;

    @SerializedName("available")
    private int available;

    @SerializedName("id")
    private String id;
}