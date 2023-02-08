import 'dart:io';

List Char = [
  'Z',
  'Q',
  'Y',
  'G',
  'F',
  'X',
  'W',
  'N',
  'V',
  'P',
  'O',
  'U',
  'T',
  'M',
  'L',
  'I',
  'H',
  'E',
  'K',
  'J',
  'D',
  'C',
  'S',
  'R',
  'B',
  'A',
];
void main(List<String> args) {
  print("Enter String: ");
  String str = stdin.readLineSync()!;
  print("Select Encode,Decode(enter 1,2):");
  int mode = int.parse(stdin.readLineSync()!);

  if (mode == 1) {
    print("Encode String: " + Encode(str));
  } else if (mode == 2) {
    print("Decode String: " + Decode(str));
  }
}

String Encode(String str) {
  String encode_str = '';
  for (int i = 0; i < str.length; i++) {
    int index = Char.indexOf(str[i].toUpperCase());
    index = index + 5 > 25 ? (index + 5) % Char.length : index + 5;
    encode_str += Char[index];
  }
  return encode_str;
}

String Decode(String str) {
  String decode_str = '';
  for (int i = 0; i < str.length; i++) {
    int index = Char.indexOf(str[i].toUpperCase());
    index = index - 5 < 0 ? (index - 5) + Char.length : index - 5;
    decode_str += Char[index];
  }
  return decode_str;
}
