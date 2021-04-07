public class DTOclass extends DTO{
    private int id;
    private String name;
    private int playerId;

    public DTOclass(String name, int playerId) {
        this.name = name;
        this.id = 1;
        this.playerId = playerId;
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
