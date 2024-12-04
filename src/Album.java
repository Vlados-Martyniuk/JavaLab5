import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Album {
    private List<MusicComposition> compositions;

    public Album() {
        this.compositions = new ArrayList<>();
    }

    public void addComposition(MusicComposition composition) {
        if (composition == null) {
            throw new IllegalArgumentException("Композиція не може бути пустою");
        }
        compositions.add(composition);
    }

    public int getTotalDuration() {
        return compositions.stream().mapToInt(MusicComposition::getDuration).sum();
    }

    public void sortByStyle() {
        compositions.sort(Comparator.comparing(MusicComposition::getStyle));;
    }

    public List<MusicComposition> findByDurationRange(int minDuration, int maxDuration) {
        if (minDuration < 0 || maxDuration < 0 || minDuration > maxDuration) {
            throw new IllegalArgumentException("Некоректний діапазон композицфї");
        }
        List<MusicComposition> result = new ArrayList<>();
        for (MusicComposition composition : compositions) {
            if (composition.getDuration() >= minDuration && composition.getDuration() <= maxDuration) {
                result.add(composition);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Альбом містить:\n");
        for (MusicComposition composition : compositions) {
            builder.append(composition.toString()).append("\n");
        }
        return builder.toString();
    }
}
