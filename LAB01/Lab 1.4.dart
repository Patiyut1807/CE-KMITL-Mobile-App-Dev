import 'dart:io';
import 'dart:math';

void main() {
  int n = int.parse(stdin.readLineSync()!);
  var prevX = 0;
  var prevY = 0;
  double dis = 0;
  for (var i = 0; i < n; i++) {
    var coord = (stdin.readLineSync()!).split(" ");
    int x = int.parse(coord[0]);
    int y = int.parse(coord[1]);
    if (i > 0) {
      dis += sqrt(pow(x - prevX, 2) + pow(y - prevY, 2));
    }
    prevX = x;
    prevY = y;
  }
  var output = dis.toStringAsFixed(2);
  print("Total:$output");
}
