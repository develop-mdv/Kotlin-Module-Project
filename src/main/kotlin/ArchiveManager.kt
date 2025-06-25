import kotlin.system.exitProcess

class ArchiveManager {
    private val archives = mutableListOf<Archive>()

    fun start() {
        while (true) {
            val menuItems = mutableListOf<Pair<String, () -> Unit>>()
            menuItems.add("Создать архив" to ::createArchive)
            archives.forEach { archive ->
                menuItems.add(archive.name to { NoteManager(archive).start() })
            }
            menuItems.add("Выход" to { exitProcess(0) })
            Menu("Список архивов:", menuItems).show()
        }
    }

    private fun createArchive() {
        print("Введите имя архива: ")
        val name = readLine()?.trim() ?: ""
        if (name.isEmpty()) {
            println("Имя архива не может быть пустым.")
            return
        }
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }
} 