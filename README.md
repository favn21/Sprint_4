# UI-Тесты для сайта Яндекс Самокат

## Описание проекта

Автоматизированные UI-тесты для сайта [qa-scooter.praktikum-services.ru](https://qa-scooter.praktikum-services.ru/), написанные с использованием Java, JUnit, Selenium и WebDriverManager.  
Проект покрывает тестирование оформления заказа и раздела часто задаваемых вопросов (FAQ) с использованием паттерна Page Object.

---

##  Используемые технологии

| Технология         | Версия     |
|--------------------|------------|
| Java               | 11         |
| Maven              | 3.9.0+     |
| JUnit              | 4.13.2     |
| Selenium WebDriver | 4.21.0     |
| WebDriverManager   | 6.1.0      |

---

##  Структура проекта
```text
src/
├── main/
│   └── java/
│       └── pageobjects/           # Классы Page Object
│           ├── MainPage.java
│           ├── OrderPage.java
│           └── RentPage.java
├── test/
│   └── java/
│       └── tests/                 # Классы с автотестами
│           ├── BaseTest.java      # Базовый класс для тестов
│           ├── OrderFlowTest.java
│           └── QuestionsSectionTest.java
└── pom.xml                        # Конфигурация Maven-проекта                     
``` 
---

## Установка и настройка

1. Установите JDK 11 и настройте переменную окружения `JAVA_HOME`.
2. Установите [Maven 3.9.0+](https://maven.apache.org/download.cgi) и добавьте его в `PATH`.
3. Клонируйте репозиторий:

```bash
git clone https://github.com/favn21/Sprint_4.git
cd Sprint_4



