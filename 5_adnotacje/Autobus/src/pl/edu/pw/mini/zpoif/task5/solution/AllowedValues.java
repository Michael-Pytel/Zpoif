package pl.edu.pw.mini.zpoif.task5.solution;

public enum AllowedValues {
    ONE(1),
    THREE(3),
    FIVE(5);
	
	private final int value;

    AllowedValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    
}
