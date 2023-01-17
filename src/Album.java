import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List< Song > songs;

    public Album( String name, String artist ) {
        this.name = name;
        this.artist = artist;
        this.songs  = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong ( String title ){
        for ( Song s1 : songs) {
            if (s1.getTitle().equals(title)) {
                return true;
            }
        }
        return false ;
    }

    void addSongtoAlbum ( String name , double duration ){
        Song s = new Song( name , duration) ;
        if ( findSong(s.getTitle()) == true ){
            System.out.println("Songs Already is present in your album ");
            return ;
        } else {
            songs.add(s);
            System.out.println("New songs has been added");
        }
        return ;
    }

    //polymorphism
    public void addToPlaylistFromAlbum ( String title , LinkedList< Song > playList){
        if ( findSong(title) == true ){
            for ( Song song : songs ){
                if ( song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("Song has been added into your playlist");
                    break;
                }
            }
        } else {
            System.out.println("Song is not present in the album");
        }
    }

    public void addToPlaylistFromAlbum ( int trackNo , LinkedList<Song> playList){
        int index = trackNo - 1 ;
        if ( index >= 0 && index < songs.size()){
            playList.add(songs.get(index));
            System.out.println("Song has been added into your playlist");
        } else {
            System.out.print("Invalid track number");
        }
        return ;
    }
}
