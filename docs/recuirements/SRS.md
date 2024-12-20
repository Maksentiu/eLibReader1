# Техническое задание на проект SkillCoder

## Содержание

- [1. Введение](#1-введение)
- [2. Требования пользователя](#2-требования-пользователя)
  - [2.1 Программные интерфейсы](#21-программные-интерфейсы)
  - [2.2 Интерфейс пользователя](#22-интерфейс-пользователя)
  - [2.3 Характеристики пользователей](#23-характеристики-пользователей)
  - [2.4 Предположения и зависимости](#24-предположения-и-зависимости)
- [3. Системные требования](#3-системные-требования)
  - [3.1 Функциональные требования](#31-функциональные-требования)
  - [3.2 Нефункциональные требования](#32-нефункциональные-требования)

## 1. Введение

eLib Reader — это мобильное приложение для чтения электронных книг из виртуальной библиотеки. Пользователи смогут искать книги, читать их, добавлять
в избранное и настраивать параметры приложения. Приложение обеспечит доступ к библиотечному контенту через интернет и предоставит интуитивно понятный
интерфейс для удобного чтения.

## Границы проекта
Приложение не будет поддерживать загрузку книг на устройство и работу с физическими книгами. Оно будет доступно только для чтения форматов PDF и EPUB.

## 2. Требования пользователя

### 2.1 Программные интерфейсы

Приложение будет взаимодействовать с:
- **Библиотеки для работы с PDF и EPUB:** MuPDF или EPUBlib.
- **Системы аутентификации:**  OAuth 2.0 для авторизации пользователей через социальные сети.
- **API внешних библиотек:** для доступа к каталогам книг.
### 2.2 Интерфейс пользователя

Интерфейс приложения будет включать:
- **Экран регистрации:** позволяет пользователям зарегистрироваться или войти в аккаунт.

![Image1](https://github.com/PahanHvesco/SkillCoder/blob/master/docs/mocaps/New%20Mockup%201.png)
![Image2](https://github.com/PahanHvesco/SkillCoder/blob/master/docs/mocaps/New%20Mockup%202.png)
- **Главный экран:** с доступом к избраным книгам, настройкам прилодения, поиску новых книг для чтения и выходу из приложения.

![Image3](https://github.com/PahanHvesco/SkillCoder/blob/master/docs/mocaps/New%20Mockup%203.png)
- **Экран настроек:** сожершит настройки, например, цветовой палитры,шрифта и т.д..

![Image4](https://github.com/PahanHvesco/SkillCoder/blob/master/docs/mocaps/New%20Mockup%204.png)
- **Экран чтения книги:** содершит текст книги.

![Image5](https://github.com/PahanHvesco/SkillCoder/blob/master/docs/mocaps/New%20Mockup%205.png)
- **Экран поиска:** позволяет польхователю искать книги по различным параметрам.

![Image6](https://github.com/PahanHvesco/SkillCoder/blob/master/docs/mocaps/New%20Mockup%206.png)

**Таблица "действие пользователя - реакция":**

| Действие пользователя                            | Реакция системы                     |
|--------------------------------------------------|:------------------------------------|
| Нажатие на книгу в списке                        | Переход на экран предпросмотра книги|
| Нажатие на кнопку "Search"                       | Отображение результатов поиска      |
| Нажатие на "Читать" <br/>на экране предпросмотра | Переход на экран чтения книги   |
| Добавление книги в избранное                     | Книга добавляется в список избранного    |

### 2.3 Характеристики пользователей

- **Студенты:** 18-30 лет, технически грамотные, используют мобильные устройства для учебы.
- **Преподаватели:** 30-60 лет, опытные пользователи компьютеров, могут иметь ограниченный опыт работы с мобильными приложениями.
- **Читатели:** 20-50 лет, интересуются чтением и используют мобильные приложения для доступа к литературе.

### 2.4 Предположения и зависимости

- Наличие доступа к интернету для использования встроенных библиотек и сервисов.
- Пользователь должен иметь устройство, поддерживающее работу приложения.
- Ожидается, что пользователи имеют базовые знания о работе с программами.

## 3. Системные требования

### 3.1 Функциональные требования

1. Пользователь должен иметь возможность зарегистрироваться и войти в систему.
2. Приложение должно позволять пользователю просматривать список книг с возможностью фильтрации и сортировки.
3. Пользователь должен иметь возможность искать книги по различным параметрам (название, автор, жанр).
4. При выборе книги из списка пользователь должен видеть экран предпросмотра с аннотацией и обложкой.
5. Приложение должно предоставлять возможность чтения книг на экране чтения с функциями изменения шрифта, фона и страниц.
6. Пользователь должен иметь возможность добавлять книги в избранное.
7. Экран избранного должен отображать все книги, добавленные пользователем.
8. Пользователь должен иметь возможность настраивать параметры приложения на экране настроек (выбор шрифта, цветовая схема, уведомления).

### 3.2 Нефункциональные требования

- **Производительность:** система должна обеспечивать время отклика менее 2 секунд при выполнении кода.
- **Надежность:** система должна быть доступна 99% времени.
- **Безопасность:** данные пользователей должны быть защищены, включая использование шифрования.

#### 3.2.1 Атрибуты качества

- **Надежность:** важна для обеспечения постоянного доступа к материалам и прогрессу пользователей.
- **Безопасность:** критично для защиты личных данных пользователей.
- **Удобство использования:** интерфейс должен быть интуитивно понятным. Измеряется через пользовательские тестирования и опросы.