void main() {
  int sum =0;
  for(int i=1;i<20;i++ ){
    if(i%2==0){
      print(i);
      sum += i;
    }
  }
  print(sum);
}