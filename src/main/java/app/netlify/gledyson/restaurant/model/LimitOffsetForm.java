package app.netlify.gledyson.restaurant.model;

public class LimitOffsetForm {

    private Integer limit = 5;
    private Integer offset = 0;

    public LimitOffsetForm() {
    }

    public LimitOffsetForm(Integer limit, Integer offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "LimitOffsetForm{" +
                "limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
