import 'dart:io';

void main() {
  var result;

  print("***** เลือกประเภทบัญชี *****");
  print("F\nS\nC");
  print("*****************************");
  stdout.write("ประเภทบัญชี: ");
  var type = stdin.readLineSync();
  stdout.write("เงินฝาก: ");
  var dep = int.parse(stdin.readLineSync()!);
  print("=================");
  switch (type) {
    case "F":
      result = calF(dep);
      break;
    case "S":
      result = calS(dep);
      break;
    case "C":
      result = calC(dep);
      break;
  }
  var interest = result.toStringAsFixed(2);
  var total = (result + dep).toStringAsFixed(2);
  print("ดอกเบี้ยในหนึ่งปี: $interest");
  print("รวมยอดเงิน: $total");
}

double calF(dep) {
  var rate = [2.5, 3.0, 3.75];
  var rateIndex;
  if (dep > 0 && dep < 500000)
    rateIndex = 0;
  else if (dep < 1000000)
    rateIndex = 1;
  else if (dep > 1000000) rateIndex = 2;
  return dep * rate[rateIndex] / 100;
}

double calS(dep) {
  var rate = [2.25, 2.75, 3.5];
  var rateIndex;
  if (dep > 0 && dep < 500000)
    rateIndex = 0;
  else if (dep < 1000000)
    rateIndex = 1;
  else if (dep > 1000000) rateIndex = 2;
  return dep * rate[rateIndex] / 100;
}

double calC(dep) {
  var rate = [2.0, 2.5, 3.25];
  var rateIndex;
  if (dep > 0 && dep < 500000)
    rateIndex = 0;
  else if (dep < 1000000)
    rateIndex = 1;
  else if (dep > 1000000) rateIndex = 2;
  return dep * rate[rateIndex] / 100;
}
