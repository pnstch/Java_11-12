package org.example;

/**
 * DAO-класс для работы с данными пользователей
 */
public interface UserDao {

    /**
     * Получение пользователя по ID
     *
     * @param id - ID для поиска
     * @return найденный пользователь
     */
    User getById(int id);

    /**
     * Обновление данных пользователя (того, чьё  ID введёт пользователь)
     *
     * @param id - ID для поиска
     * @param last_name - фамилия
     * @param first_name - имя
     * @param surname - отчество
     * @param post - должность
     * @param department_id - ID отдела
     * @param salary - зарлата
     */
    void update(int id, String last_name, String first_name, String surname, String post, int salary, int department_id);

    /**
     * Создание нового пользователя
     *
     * @param user - данные пользователя
     */
    void create(User user);

    /**
     * Удаление пользователя по ID
     *
     * @param id - ID пользователя, которого нужно удалить
     */
    void delete(int id);

    /**
     * Добавление отдела в таблицу отделов
     *
     * @param name - название отдела
     */
    void add_department(String name);
}