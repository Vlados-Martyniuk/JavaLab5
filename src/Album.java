/**
 * Клас, що представляє музичний альбом.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Album {
    private List<MusicComposition> compositions;

    /**
     * Конструктор для створення пустого альбому.
     */
    public Album() {
        this.compositions = new ArrayList<>();
    }

    /**
     * Додає композицію до альбому.
     *
     * @param composition композиція, яку потрібно додати
     * @throws IllegalArgumentException якщо композиція є null
     */
    public void addComposition(MusicComposition composition) {
        if (composition == null) {
            throw new IllegalArgumentException("Композиція не може бути пустою");
        }
        compositions.add(composition);
    }

    /**
     * Повертає загальну тривалість усіх композицій в альбомі.
     *
     * @return тривалість у секундах
     */
    public int getTotalDuration() {
        return compositions.stream().mapToInt(MusicComposition::getDuration).sum();
    }

    /**
     * Сортує композиції в альбомі за стилем.
     */
    public void sortByStyle() {
        compositions.sort(Comparator.comparing(MusicComposition::getStyle));;
    }

    /**
     * Знаходить композиції в межах заданого діапазону тривалості.
     *
     * @param minDuration мінімальна тривалість
     * @param maxDuration максимальна тривалість
     * @return список композицій, які відповідають діапазону
     * @throws IllegalArgumentException якщо діапазон є некоректним
     */
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

    /**
     * Повертає текстове представлення альбому.
     *
     * @return текстове представлення альбому
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Альбом містить:\n");
        for (MusicComposition composition : compositions) {
            builder.append(composition.toString()).append("\n");
        }
        return builder.toString();
    }
}
