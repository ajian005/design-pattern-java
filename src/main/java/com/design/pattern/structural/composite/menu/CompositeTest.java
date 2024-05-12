package com.design.pattern.structural.composite.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 构成层叠式菜单的元素
 */
abstract class MenuComponent {
    // 菜单项或子菜单名称
    protected String name;
    public void printName() {
        System.out.println(name);
    }
    public abstract boolean addMenuElement(MenuComponent element);
    public abstract boolean removeMenuElement(MenuComponent element);
    public abstract List<MenuComponent> getElement();
}

class MenuItem extends MenuComponent {
    public MenuItem(String name) {
        this.name = name;
    }
    public boolean addMenuElement(MenuComponent element) {
        return false;
    }
    public boolean removeMenuElement(MenuComponent element) {
        return false;
    }
    public List<MenuComponent> getElement() {
        return null;
    }
}

class Menu extends MenuComponent {
    private List<MenuComponent> elementList;

    public Menu(String name) {
        this.name = name;
        this.elementList = new ArrayList<MenuComponent>();
    }

    @Override
    public boolean addMenuElement(MenuComponent element) {
        return elementList.add(element);
    }

    @Override
    public boolean removeMenuElement(MenuComponent element) {
        return elementList.remove(element);
    }

    @Override
    public List<MenuComponent> getElement() {
        return elementList;
    }
}


public class CompositeTest {
    public static void main(String[] args) {
        MenuComponent mainMenu = new Menu("Insert");
        MenuComponent subMenu = new Menu("Chart");
        MenuComponent element = new MenuItem("On This Sheet");
        mainMenu.addMenuElement(subMenu);
        subMenu.addMenuElement(element);
        printMenus(mainMenu);
    }

    private static void printMenus(MenuComponent ifile) {
        ifile.printName();
        List<MenuComponent> children = ifile.getElement();
        if (children == null) {
            return;
        }
        for (MenuComponent element : children) {
            printMenus(element);
        }
    }
}
