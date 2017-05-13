package ru.ematveev.start;

import ru.ematveev.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Сlass Tracker.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 25.12.2016.
 */
public class Tracker {
    /**
     * List items.
     */
    private List<Item> items = new ArrayList<>();
    /**
     * create object for generation random number.
     */
    private static final Random RN = new Random();

    /**
     * metod of add the new item.
     *
     * @param item item.
     * @return item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * metod of update the item.
     *
     * @param item   item.
     * @param itemID ItemID.
     */
    public void update(String itemID, Item item) {
        for (int index = 0; index < items.size(); index++) {
            if (item != null && items.get(index).getId().equals(itemID)) {
                items.set(index, item);
                break;
            }
        }

    }

    /**
     * metod of delete the item.
     *
     * @param item item.
     */
    public void delete(Item item) {
        for (int index = 0; index < items.size(); index++) {
            if (item != null && items.get(index).getId().equals(item.getId())) {
                items.remove(index);
                break;
            }
        }
    }

    /**
     * metod of extraction all the items.
     *
     * @return item.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        result.addAll(items);
        return result;
    }

    /**
     * metod of find the item by name.
     *
     * @param name ID.
     * @return name.
     */
    public Item findByName(String name) {
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
     *
     * @param id id.
     * @return item.
     */
    public Item findById(String id) {
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
     * The method for delete the all items.
     */
    public void deleteAll() {
        items.clear();
    }

    /**
     * metod of generate the random number for ID.
     *
     * @return String.
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}


