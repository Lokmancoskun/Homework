package pojo;


import io.cucumber.java.mk_latn.No;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class SearchRequestBody {
    private String text;
    private int size;
    private int skip;

    public SearchRequestBody(String text, int size, int skip) {
        this.text = text;
        this.skip = skip;

        if(size < 0 ) this.size = 0;
        else this.size = size;
    }
}
