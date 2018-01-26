package Enums;

public enum MovieFormat {

    DVD(ProductState.PHYSICAL),
    BLU_RAY(ProductState.PHYSICAL),
    STREAM(ProductState.DOWNLOADABLE);

    private final ProductState state;

    MovieFormat(ProductState state){
        this.state = state;
    }

    public ProductState getState(){
        return this.state;
    }

}
