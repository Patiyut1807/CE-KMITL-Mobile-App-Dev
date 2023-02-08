import 'dart:io';

void main(List<String> args) {
  print("Enter String: ");
  String str = stdin.readLineSync()!;
  var map = Map();

  str.runes.forEach((element) {
    if (!map.containsKey(element)) {
      map[element] = 1;
    } else {
      map[element] += 1;
    }
  });

  map.forEach((key, value) {
    String buffer = "";
    for (var i = 0; i < value; i++) {
      if (i % 5 == 0 && i != 0) {
        buffer += '|';
      }
      buffer += '-';
    }
    print(String.fromCharCode(key) + ':' + "$buffer");
  });
}
