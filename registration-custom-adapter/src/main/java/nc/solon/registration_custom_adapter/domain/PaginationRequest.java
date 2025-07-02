package nc.solon.registration_custom_adapter.domain;

public class PaginationRequest {
    private final int page;
    private final int size;
    private final String direction;

    public PaginationRequest(int page, int size, String direction) {
        this.page = page;
        this.size = size;
        this.direction = direction;
    }

    public int getPage() { return page; }
    public int getSize() { return size; }
    public String getDirection() { return direction; }
}