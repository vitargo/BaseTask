package com.github.gui.crud.models;

import com.github.gui.crud.utils.ReflectionUtils;
import com.github.gui.crud.utils.people.PersonColumn;
import com.github.gui.crud.entity.Person;
import com.github.gui.crud.exceptions.CrudException;
import com.github.gui.crud.services.IPeopleService;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PeopleTableModel extends AbstractTableModel {

    private final List<Field> tableColumn;
    private List<Person> people = new ArrayList<>();
    private IPeopleService peopleService;

    public PeopleTableModel(IPeopleService peopleService, List<Field> tableColumn) {
        this.peopleService = peopleService;
        this.tableColumn = tableColumn;
    }

    public PeopleTableModel refresh() {
        this.people = this.peopleService.readAll();
        return this;
    }

    public void setPeopleService(IPeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public IPeopleService getPeopleService() {
        return this.peopleService;
    }

    @Override
    public int getRowCount() {
        return this.people.size();
    }

    @Override
    public String getColumnName(int col) {
        return this.tableColumn.get(col)
                .getAnnotation(PersonColumn.class).name();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col > 0;
    }

    @Override
    public int getColumnCount() {
        return this.tableColumn.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = this.people.get(rowIndex);
        Field field = this.tableColumn.get(columnIndex);
        return ReflectionUtils.getValue(field, person);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Person p = this.people.get(rowIndex);
        Class<? extends Person> clz = p.getClass();
        Field[] fields = clz.getDeclaredFields();
        try {
            Field field = fields[columnIndex + 1];
            field.setAccessible(Boolean.TRUE);
            Class<?> type = field.getType();
            if (type.equals(int.class)) {
                field.setInt(p, Integer.parseInt((String) aValue));
            } else {
                field.set(p, aValue);
            }
        } catch (IllegalAccessException e) {
            throw new CrudException(e.getMessage());
        }
        update(p);
    }

    public void create(Person person) {
        this.peopleService.create(person);
    }

    public void readAll() {
        this.people = this.peopleService.readAll();
    }

    public void update(Person person) {
        this.peopleService.update(person.getId(), person);
    }

    public void update(long id, Person person) {
        this.peopleService.update(id, person);
    }

    public void delete(long personId) {
        this.peopleService.delete(personId);
    }
}
