/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Класс работника
 */

package aboutWorker;

import java.io.Serializable;
import java.time.LocalDate;

public class Worker implements Serializable {

    /** ID работника */
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    /** Имя работника */
    private String name; //Поле не может быть null, Строка не может быть пустой

    /** Координаты работника */
    private Coordinates coordinates; //Поле не может быть null

    /** Дата создания работника */
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    /** Зарплата работника */
    private Long salary; //Поле не может быть null, Значение поля должно быть больше 0

    /** Дата начала работы */
    private LocalDate startDate; //Поле не может быть null

    /** Дата окончания работы */
    private LocalDate endDate; //Поле может быть null

    /** Должность работника */
    private Position position; //Поле не может быть null

    /** Работодатель */
    private Organization organization; //Поле не может быть null

    /**
     * Конструткор - создание нового объекта
     * @param name - имя
     * @param coordinates - координаты
     * @param salary - зарплата
     * @param position - должность
     * @param organization - работодатель
     */
    public Worker(String name, Coordinates coordinates, Long salary, LocalDate startDate, LocalDate endDate, Position position, Organization organization) {
        this.id = (int) (Math.random() * 10000);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.organization = organization;
    }

    /**
     * @return информацию о работнике
     */
    @Override
    public String toString() {
        return "Worker: " +
                "\nid = " + id +
                "\nname = " + name +
                "\ncoordinates = " + coordinates +
                "\ncreationDate = " + creationDate +
                "\nsalary = " + salary +
                "\nstartDate = " + startDate +
                "\nendDate = " + endDate +
                "\nposition = " + position +
                "\norganisation = " + organization + "\n";
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public Long getSalary() {
        return this.salary;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public Position getPosition() {
        return this.position;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}




