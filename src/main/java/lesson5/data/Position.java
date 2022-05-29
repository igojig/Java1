package lesson5.data;

public enum Position {
    DIRECTOR("Директор"),
    MANAGER("менеджер"),
    PROGRAMMER("программист"),
    ACCAUNTANT("бухгалтер"),
    DRIVER("водитель"),
    SECURITY("охранник"),
    CLEANER("уборщица");

    final String position;

    Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return " должность ='" + position + '\'';
    }
}
