package Enums;

public enum ReviewHelpful {

    YES(1),
    NO(0);

    private final int value;

    ReviewHelpful(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static enum Profession {
    }
}
