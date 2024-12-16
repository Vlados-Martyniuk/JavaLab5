/**
 * Головний клас програми для демонстрації роботи з музичним альбомом.
 */
public class Main {
    public static void main(String[] args) {
        Album album = new Album();

        album.addComposition(new TechnoComposition("Song 5", "Artist X",160));
        album.addComposition(new PopComposition("Song 1", "Artist A", 210));
        album.addComposition(new RockComposition("Song 2", "Artist B", 180));
        album.addComposition(new RapComposition("Song 3", "Artist C", 250));
        album.addComposition(new TechnoComposition("Song 4", "Artist D",150));

        System.out.println(album);
        System.out.println("Тривалість альбому: " + album.getTotalDuration() + " секунд");

        album.sortByStyle();
        System.out.println("Відсортовано за стилем:\n" + album);

        System.out.println("Композиції в діапазоні від 200 до 500 секунд:");
        for (MusicComposition composition : album.findByDurationRange(200, 500)) {
            System.out.println(composition);
        }

    }
}