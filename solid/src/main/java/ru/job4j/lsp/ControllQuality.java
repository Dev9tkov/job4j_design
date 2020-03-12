package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class ControllQuality {
    private List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public boolean add(Food food) throws ParseException {
        boolean rsl = false;
        for (Storage val : storages) {
            if (val.addFood(food)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    /**
     * Достает все продукты из всех хранилищ
     * @return лист всех продуктов из всех хранилищ
     */
    private List<Food> saveList() {
        List<Food> saveList = new ArrayList<>();
        for (Storage val : storages) {
            saveList.addAll(val.getFoods());
        }
        return saveList;
    }

    /**
     * Распределяет продукты по всем хранилищам. Использует метод add     *
     * @param list Food
     * @throws ParseException
     */
    private void addAllFoods(List<Food> list) throws ParseException {
        for (Food val : list) {
            add(val);
        }
    }

    /**
     * Извлекает все продукты и перераспределяет заново
     * @throws ParseException
     */
    public void resort() throws ParseException {
        List<Food> tmpList = saveList();
        addAllFoods(tmpList);
    }
}
