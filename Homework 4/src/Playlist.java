public class Playlist extends SongCollection {

    private String description;


    public Playlist(String name, String description) {

        super(name);
        this.description = description;
    }

    //Getters and Setters
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
