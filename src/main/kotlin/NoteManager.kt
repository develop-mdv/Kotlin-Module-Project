class NoteManager(private val archive: Archive) {
    fun start() {
        var breakLoop = false
        while (!breakLoop) {
            val menuItems = mutableListOf<Pair<String, () -> Unit>>()
            menuItems.add("Создать заметку" to ::createNote)
            archive.notes.forEach { note ->
                menuItems.add(note.name to { showNote(note) })
            }
            menuItems.add("Назад" to { breakLoop = true })
            Menu("Заметки архива '${archive.name}':", menuItems).show()
        }
    }

    private fun createNote() {
        print("Введите имя заметки: ")
        val name = readLine()?.trim() ?: ""
        if (name.isEmpty()) {
            println("Имя заметки не может быть пустым.")
            return
        }
        print("Введите текст заметки: ")
        val text = readLine()?.trim() ?: ""
        if (text.isEmpty()) {
            println("Текст заметки не может быть пустым.")
            return
        }
        archive.notes.add(Note(name, text))
        println("Заметка '$name' создана.")
    }

    private fun showNote(note: Note) {
        println("\nИмя: ${note.name}")
        println("Текст: ${note.text}")
        println("Нажмите Enter для возврата.")
        readLine()
    }
} 