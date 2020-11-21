import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Scanner;

public class Library {

    private String ownerName;
    private SongCollection home;
    private Hashtable<String, Playlist> playlists;

    public Library(String ownerName) {

        this.ownerName = ownerName;
        this.home = new SongCollection("home");
        this.playlists = new Hashtable<String, Playlist>();
    }

    public SongCollection getHome() {
        return this.home;
    }

    public String getOwnerName() {

        return this.ownerName;
    }

    //Adds playlist
    public void addPlaylist(Playlist playlist) {
        this.playlists.put(playlist.getName(), playlist);
        playlist.getSongs().forEach((title, song) ->
        {
            this.home.addSong((Song) song);

        });
    }

    //Prints libraries
    public void printLibrary() {
        System.out.println("Library owner: " + ownerName);
        System.out.println("Songs in Library: ");
        this.home.printSongs();

        this.playlists.forEach((name, playlist) -> {
            System.out.println("PLAYLIST NAME: " + playlist.getName());
            playlist.printSongs();


        });


    }

    //Uploads demo songs
    public void uploadDemoSongs() {
        Path file = Paths.get("E:/College/Homework3/demo_songs.txt");
        InputStream input = null;
        try {
            input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader((input)));
            String s = null;
            while ((s = reader.readLine()) != null) {

                System.out.println(s);
            }
            input.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    //Creates the playlist
    public Playlist createPlaylist(Scanner inputDevice) {
        System.out.print("What would you like to name your playlist?");
        String name = inputDevice.nextLine();
        System.out.print("What do you want the description to be?");
        String description = inputDevice.nextLine();
        Playlist playlist = new Playlist(name, description);
        char addAnother = 'n';
        do {
            System.out.print("Song name: ");
            String title = inputDevice.nextLine();
            System.out.print("Artist name: ");
            String artist = inputDevice.nextLine();
            System.out.print("Genre: ");
            String genre = inputDevice.nextLine();
            Song song = new Song(title, artist, genre);
            playlist.addSong(song);
            System.out.print("Would you like to add another song to the playlist? (y/n): ");
            addAnother = inputDevice.nextLine().charAt(0);

        } while (Character.toLowerCase(addAnother) == 'y');
        return playlist;
    }

    public Hashtable<String, Playlist> getPlaylists() {
        return playlists;
    }


}
