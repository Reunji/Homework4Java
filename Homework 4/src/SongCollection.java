import java.util.Hashtable;

public class SongCollection {

    private String name;
    private Hashtable<String, Song> songs;


    public SongCollection(String name) {
        this.name = name;
        songs = new Hashtable<String, Song>();
    }

    public Hashtable getSongs() {
        return songs;

    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Song lookUpSong(String title) {

        return this.songs.get(title);
    }


    public void addSong(Song song) {
        this.songs.put(song.getTitle(), song);
    }

    //Prints out everything about the song
    public void printSongs() {
        this.songs.forEach((title, song) ->
        {
            String genre = song.getGenre();
            String artist = song.getArtist();
            System.out.println("---------------------------------------");
            System.out.println("Title: " + title);
            System.out.println("Artist: " + artist);
            System.out.println("Genre: " + genre);


        });
    }

}
