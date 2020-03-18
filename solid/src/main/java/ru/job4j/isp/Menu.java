package ru.job4j.isp;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Ilya Devyatkov
 * @since 18.03.2020
 */
public class Menu implements CreateMenu, ExecuteAction, ShowMenu {
    private List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * Выбор пункта меню
     * @param name название пункта меню
     */
    @Override
    public void select(String name) {
        Optional<MenuItem> menuItem =
        menuItems.stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst();
        if (menuItem.isPresent()) {
            MenuItem rsl = menuItem.get();
            execute(rsl);
        }
    }

    /**
     * Выполняет действие по указанному пункту
     * @param menuItem пункт меню
     */
    @Override
    public void execute(MenuItem menuItem) {
        //to do action
    }

    /**
     * Создание упорядоченного меню
     * @param menu
     * @return
     */
    @Override
    public Set<String> create(Map<String, MenuItem> menu) {
        Set<String> fullMenu = new TreeSet<>();
        Queue<String> queue = new LinkedList<>(menu.keySet());
        while (!queue.isEmpty()) {
            String name = queue.poll();
            if(!queue.contains(name)) {
                MenuItem submenu = menu.get(name);
                List<String> list = submenu.getItems();
                if(list != null) {
                    for(String val : list) {
                        fullMenu.add(name.concat(val));
                    }
                }
                fullMenu.add(submenu.getName());
            }
        }
        return fullMenu;
    }

    /**
     * Вывод меню на консоль
     * По кол-ву точек определяет сколько раз нужно проставить "---"
     * @param menu меню
     */
    @Override
    public void show(Set<String> menu) {
        String cherta = "---";
        for (String val : menu) {
            int chert = checkDot(val) - 1;
            for (int i = 0; i < chert; i++) {
                System.out.print(cherta);
            }
            System.out.println(val);
        }
    }

    /**
     * Считает кол-во точек в имени меню, побочный метод
     * @param name
     * @return
     */
    private Integer checkDot(String name) {
        int rsl = 0;
        for (Character val : name.toCharArray()) {
            if (val.equals('.')) {
                rsl++;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        MenuItem mi1 = new MenuItem("Пункт 1.", Arrays.asList("1.", "2."));
        MenuItem mi2 = new MenuItem("Пункт 2.");
        MenuItem mi3 = new MenuItem("Пункт 3.", Arrays.asList("1.", "2."));
        MenuItem mi4 = new MenuItem("Пункт 3.1.", Arrays.asList("1.", "2."));
        MenuItem mi5 = new MenuItem("Пункт 4.", Arrays.asList("1.", "2."));

        List<MenuItem> list = List.of(mi1, mi2, mi3, mi4, mi5);
        Map<String, MenuItem> stringMenuItem = list.stream()
                .collect(Collectors.toMap(MenuItem::getName, Function.identity()));
        Menu menu = new Menu(list);
        menu.show(menu.create(stringMenuItem));
    }
}
