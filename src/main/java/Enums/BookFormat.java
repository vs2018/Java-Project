package Enums;

public enum BookFormat {

    KINDLE_EDITION(ProductState.DOWNLOADABLE),
    HARDCOVER(ProductState.PHYSICAL),
    PAPERBACK(ProductState.PHYSICAL),
    AUDIO_CD(ProductState.PHYSICAL);

    private final ProductState state;

    BookFormat(ProductState state){
        this.state = state;
    }

    public ProductState getState(){
        return this.state;
    }


}
