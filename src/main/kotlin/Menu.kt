import java.util.Scanner

class Menu(
    private val title: String,
    private val items: List<Pair<String, () -> Unit>>
) {
    fun show() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("\n$title")
            items.forEachIndexed { index, item -> println("$index. ${item.first}") }
            print("Выберите пункт меню: ")
            val input = scanner.nextLine()
            val choice = input.toIntOrNull()
            if (choice == null || choice !in items.indices) {
                println("Ошибка: введите корректный номер пункта меню.")
                continue
            }
            items[choice].second.invoke()
            break
        }
    }
} 