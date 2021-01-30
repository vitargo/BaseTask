# BaseTask

## Cluster "Conditional operators"

1. If a - even count a * b, otherwise a + b.
2. Determine which quarter belongs to the point with coordinates (x,y).
3. Find sum of only positive number of three given numbers.
4. Calculate max(a*b*c, a+b+c)+3.
5. Write a grading program based on the student’s rating according the following rules:

   Rate | Result
:------:|:------:
  0-19  |   F
  20-39 |   E
  40-59 |   D
  60-74 |   C
  75-89 |   B
  90-100|   A

---  
## Cluster "Loops"
1. Find the sum of even numbers and count them in the range from 1 to 99.
2. Check for a prime number?
3. Find the root of a natural number to the nearest whole (consider and binary search method).
4. Calculate the factorial of n. n! = 1*2*...*n-1*n;!
5. Calculate the sum of the digits of a given number.
6. Output a number that is a mirror reflection of a digit of a given number, for example, given the number 123, output 321.
  
---  
## Cluster "Arrays"
1. Find minimum array element.
2. Find maximum array element.
3. Find the minimum array element index.
4. Find maximum array element index.
5. Calculate the sum of odd-numbered array elements.
6. Reverse array.
7. Count odd array elements.
8. Swap the first and second half of the array, for example for array 1 2 3 4, result 3 4 1 2.
9. Sort array (Bubble Sort, Select Sort, Insert Sort).
10. Sort array (Quick Sort, Merge Sort, Shell Sort, Heap Sort).
  
---  
## Cluster "Methods"
1. Get the line name of the day of the week by the number of the day.
2. Enter a number (0-999) and you get a string with a number as text.
3. Enter a string that contains the number as text (0-999) and you get a number of digits.
4. Find the distance between two points in a two-dimensional Cartesian space.
5. Enter a number (0-999 billions) and you get a string with a number as text.
6. Enter a string that contains the number as text (0-999 billions) and you get a number of digits.

---
## Five ints
Даны 5 чисел (тип int). Вывести вначале наименьшее, а затем наибольшее из данных чисел.

---
## Four ints
Даны 4 числа типа int. Сравнить их и вывести наименьшее на консоль.
Вывести на консоль количество максимальных чисел среди этих четырех.

---
## NameSake
Даны имена 2х человек (тип String). Если имена равны, то вывести сообщение о том, что люди являются тезками.

---
## Seasons
Дано число месяца (тип int). Необходимо определить время года (зима, весна, лето, осень) и вывести на консоль.

---
## Discriminant
ax2 + bx + c

---
### Application “Randomizer”

Консольное приложение, при запуске которого пользователю предлагается установить диапазон случайных чисел рандомайзера путем ввода минимального и максимального чисел, предположим (min = 1, max = 100). Валидация: числа не должны быть отрицательными. Минимальное стартовое число диапазона должно быть больше либо равно 1. Максимальное число должно быть меньше либо равно 500. Числа с плавающей точкой запрещены.
После установки min и max чисел диапазона у пользователя должно быть в арсенале только три команды: “generate”, “exit”, “help”. Последняя команда работает как обычный хелпер (путеводитель) для пользователя, реализация на усмотрение исполнителя.
При вводе команды “exit” - приложение закрывается, пользователю сообщается, что приложение больше не активно (Optional - можно обработать дополнительным вопросом: “Are you sure that you want to quit the app?”).
При вводе команды “generate” - приложение генерирует в консоль случайное число которое находится в заданном пользователем диапазоне при старте. При каждой генерации нового числа - числа не повторяются. Другими словами, числа уникальны и могут появится только единожды.



