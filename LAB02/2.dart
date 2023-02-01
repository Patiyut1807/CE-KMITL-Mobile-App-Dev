import 'dart:io';

void main() {
  var command = stdin.readLineSync().toString();
  var buffer = ["", "", "", "", ""];
  List result;
  command.split('').forEach((ch) => {
        if (ch == "U")
          {
            result = upArrow(),
            buffer[0] += result[0] + ' ',
            buffer[1] += result[1] + ' ',
            buffer[2] += result[2] + ' ',
            buffer[3] += result[3] + ' ',
            buffer[4] += result[4] + ' ',
          }
        else if (ch == "D")
          {
            result = downArrow(),
            buffer[0] += result[0] + ' ',
            buffer[1] += result[1] + ' ',
            buffer[2] += result[2] + ' ',
            buffer[3] += result[3] + ' ',
            buffer[4] += result[4] + ' ',
          }
        else if (ch == "L")
          {
            result = leftArrow(),
            buffer[0] += result[0] + ' ',
            buffer[1] += result[1] + ' ',
            buffer[2] += result[2] + ' ',
            buffer[3] += result[3] + ' ',
            buffer[4] += result[4] + ' ',
          }
        else if (ch == "R")
          {
            result = rightArrow(),
            buffer[0] += result[0] + ' ',
            buffer[1] += result[1] + ' ',
            buffer[2] += result[2] + ' ',
            buffer[3] += result[3] + ' ',
            buffer[4] += result[4] + ' ',
          }
      });
  print(buffer[0]);
  print(buffer[1]);
  print(buffer[2]);
  print(buffer[3]);
  print(buffer[4]);
}

List upArrow() {
  return ["  *  ", " *** ", "* * *", "  *  ", "  *  "];
}

List downArrow() {
  return ["  *  ", "  *  ", "* * *", " *** ", "  *  "];
}

List leftArrow() {
  return ["  *  ", " *   ", "*****", " *   ", "  *  "];
}

List rightArrow() {
  return ["  *  ", "   * ", "*****", "   * ", "  *  "];
}
