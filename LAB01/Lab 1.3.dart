import 'dart:io';

void main() {
  var priceRate = [100, 98, 95, 90];
  print("Enter n:");
  int n = int.parse(stdin.readLineSync()!);
  int price = 0;
  if (n > 0 && n == 1) {
    price = priceRate[0] * n;
    print(price);
  } else if (n <= 4) {
    price = priceRate[1] * n;
    print(price);
  } else if (n <= 9) {
    price = priceRate[2] * n;
    print(price);
  } else if (n >= 10) {
    price = priceRate[3] * n;
    print(price);
  } else {
    print("ERROR");
  }
}
