package ru.ematveev.start;

import ru.ematveev.model.Item;
import java.util.Random;
/**
 * Сlass Tracker.
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 25.12.2016.
 */
public class Tracker {
    /**
     * The number of elements in the array.
     */
    private final int count = 10;
    /**
     * Array for storage the items.
     */
    private Item[] items = new Item[count];
    /**
     * counter index in Array items.
     */
    private int position = 0;
    /**
     * create object for generation random number.
     */
    private static final Random RN = new Random();

    /**
     * metod of add the new item.
     * @param item item.
     * @return item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * metod of update the item.
     * @param item item.
     * @param itemID ItemID.
     */
    public void update(String itemID, Item item) {
        for (int index = 0; index < items.length; index++) {
            if (item != null && items[index].getId().equals(itemID)) {
                items[index] = item;
                break;
            }
        }
    }
    /**
     * metod of delete the item.
     * @param item item.
     */
    public void delete(Item item) {
        for (int index = 0; index < items.length; index++) {
            if (item != null && items[index].getId().equals(item.getId())) {
                items[index] = null;
                position--;
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                break;
            }
        }
    }
    /**
     * metod of extraction all the items.
     * @return item.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }


    /**
     * metod of find the item by name.
     * @param name ID.
     * @return name.
     */
    protected Item findByName(String name) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * metod of find search item by ID.
     * @param id id.
     * @return item.
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * metod of generate the random number for ID.
     * @return String.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}






