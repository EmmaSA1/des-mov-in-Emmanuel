import 'package:flutter/material.dart';
import 'package:flutter_application_1/Student.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;
  String name = "Emmanuel";
  int age = 21;
  bool programming = true;

  // Ahora usamos lista de Students en lugar de strings
  final List<Student> studentList = [];
  final Student student1 = Student("Emmanuel", "12345");

  final TextEditingController _txtNameCTRL = TextEditingController();
  final TextEditingController _txtIdCTRL = TextEditingController(); // cambiado el nombre

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  void _decrementCounter() {
    if (_counter <= 0) {
      _showMyDialog();
    } else {
      setState(() {
        _counter--;
      });
      print("Contador actualizado: $_counter");
    }
  }

  Widget _getAllStudents() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        const SizedBox(height: 12),
        const Text("Students list:"),
        const SizedBox(height: 12),
        ...studentList.map((s) => Text("- ${s.name} (ID: ${s.studentId})")).toList(),
      ],
    );
  }

  void _addStudent() {
    final name = _txtNameCTRL.text.trim();
    final studentId = _txtIdCTRL.text.trim();

    if (name.isEmpty || studentId.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text("El nombre y el ID no pueden estar vacíos")),
      );
      return;
    }

    setState(() {
      studentList.add(Student(name, studentId));
    });

    _txtNameCTRL.clear();
    _txtIdCTRL.clear();
  }

  Future<void> _showMyDialog() async {
    return showDialog<void>(
      context: context,
      barrierDismissible: false,
      builder: (BuildContext context) {
        return AlertDialog(
          title: const Text('Alerta'),
          content: const SingleChildScrollView(
            child: ListBody(
              children: <Widget>[
                Text('Hijoles que crees, no puedes tener números negativos, ni modo dote'),
              ],
            ),
          ),
          actions: <Widget>[
            TextButton(
              child: const Text('Okidoki'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: SingleChildScrollView( // para evitar overflow
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              const Text('You have pushed the button this many times:'),
              Text(
                '$_counter',
                style: Theme.of(context).textTheme.headlineMedium,
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 8),
                child: TextField(
                  controller: _txtNameCTRL,
                  decoration: const InputDecoration(
                    labelText: "Name:",
                    border: OutlineInputBorder(),
                  ),
                ),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 8),
                child: TextField(
                  controller: _txtIdCTRL,
                  decoration: const InputDecoration(
                    labelText: "Student Id:",
                    border: OutlineInputBorder(),
                  ),
                ),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 8),
                child: ElevatedButton(
                  onPressed: _addStudent,
                  child: const Text("Add Student"),
                ),
              ),
              const SizedBox(height: 15),
              Text('Nombre: $name'),
              Text('Edad: $age'),
              Text('¿Soy bueno para la chamba? $programming'),
              const SizedBox(height: 15),
              Text("Original Student: ${student1.name}"),
              Text("Her Student Id is: ${student1.studentId}"),
              _getAllStudents(),
            ],
          ),
        ),
      ),
      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          FloatingActionButton(
            onPressed: _incrementCounter,
            tooltip: 'Increment',
            child: const Icon(Icons.add),
          ),
          const SizedBox(width: 10),
          FloatingActionButton(
            onPressed: _decrementCounter,
            tooltip: 'Decrement',
            child: const Icon(Icons.remove),
          ),
        ],
      ),
    );
  }
}
