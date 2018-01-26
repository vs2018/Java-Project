package Enums;

public enum MusicFormat {

    STREAMING(ProductState.DOWNLOADABLE),
    MP3(ProductState.DOWNLOADABLE),
    AUDIO_CD(ProductState.PHYSICAL),
    VINYL(ProductState.PHYSICAL);

    private final ProductState state;

    MusicFormat(ProductState state){
        this.state = state;
    }

    public ProductState getState(){
        return this.state;
    }
}
