# VIA Mebel: Landing Page & CMS

Это монорепозиторий для проекта "VIA Mebel", включающий в себя веб-приложение на Spring Boot (бэкенд) и систему управления контентом на Strapi (CMS). Проект представляет собой современный лендинг для мебельной компании, контент которого полностью управляется через удобную админ-панель.

## 📁 Структура проекта

Проект организован как монорепозиторий, содержащий два независимых приложения:

```
landing-strapi/
├── backend/        # Spring Boot приложение (Java)
├── cms/            # Strapi CMS (Node.js)
├── .gitignore      # Игнорируемые файлы
└── README.md       # Это описание
```

*   **`backend/`**: Java-проект на Spring Boot. Отвечает за:
    *   Отображение HTML-страниц с помощью Thymeleaf.
    *   Получение данных из Strapi по API.
    *   Обработку контактной формы и отправку писем через SMTP.
*   **`cms/`**: Проект на Strapi. Отвечает за:
    *   Предоставление админ-панели для управления всем контентом сайта.
    *   Хранение данных в базе (SQLite, PostgreSQL и т.д.).
    *   Предоставление REST API для `backend` приложения.

---

## 🚀 Быстрый старт

Для запуска проекта вам понадобятся:
*   Java 17 (или выше)
*   Maven 3.x
*   Node.js v18 (или выше)
*   NPM или Yarn

Проект требует одновременного запуска двух серверов: Strapi CMS и Spring Boot.

### 1. Запуск CMS (Strapi)

1.  **Перейдите в директорию `cms/`:**
    ```bash
    cd cms
    ```

2.  **Установите зависимости:**
    ```bash
    npm install
    ```

3.  **Запустите Strapi в режиме разработки:**
    ```bash
    npm run develop
    ```
    *   Сервер CMS будет доступен по адресу **`http://localhost:1337`**.
    *   Админ-панель будет доступна по адресу **`http://localhost:1337/admin`**.
    *   При первом запуске создайте аккаунт администратора.

### 2. Запуск Backend (Spring Boot)

1.  **Откройте новый терминал** (не закрывая терминал со Strapi).
2.  **Перейдите в директорию `backend/`:**
    ```bash
    cd backend
    ```

3.  **Соберите проект с помощью Maven:**
    ```bash
    mvn clean install
    ```

4.  **Запустите Spring Boot приложение:**
    ```bash
    mvn spring-boot:run
    ```
    *   Веб-приложение будет доступно по адресу **`http://localhost:8000`**.

---

## ⚙️ Конфигурация

### CMS (Strapi)

*   **API Tokens:** По умолчанию, все эндпоинты закрыты. Чтобы открыть доступ для Spring Boot, перейдите в `Settings -> Roles -> Public` и разрешите `find` для всех нужных типов контента (Header, Footer, Product и т.д.).
*   **База данных:** По умолчанию используется SQLite. Конфигурация находится в `cms/config/database.js`.

### Backend (Spring Boot)

Все основные настройки находятся в файле `backend/src/main/resources/application.properties`.

#### Настройка SMTP для контактной формы

Для работы контактной формы необходимо настроить отправку почты через Gmail:

1.  Убедитесь, что в вашем Google Аккаунте включена **двухэтапная аутентификация**.
2.  Создайте **"Пароль приложения"** в настройках безопасности вашего Google Аккаунта.
3.  Заполните следующие поля в `application.properties`:

    ```properties
    # Настройки SMTP Gmail
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=VASH_EMAIL@gmail.com
    spring.mail.password=VASH_16_ZNACHNIY_PAROL_PRILOZHENIYA
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    ```

---

## ✨ Основные технологии

*   **Бэкенд:**
    *   Java 21
    *   Spring Boot 3
    *   Spring Web
    *   Spring Mail Sender
    *   Thymeleaf (шаблонизатор)
    *   Maven

*   **CMS:**
    *   Strapi v4
    *   Node.js
    *   SQLite / PostgreSQL

*   **Фронтенд:**
    *   HTML5
    *   CSS3
    *   JavaScript
