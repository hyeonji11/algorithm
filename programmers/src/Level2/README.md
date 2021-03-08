## 1. 124 나라의 숫자(NumberOf124Country.java)

처음엔 완전탐색 문제로 알고 풀었지만 n이 너무 큰 숫자가 들어오면 시간초과가 나기 때문에 3진법을 이용하는 방법으로 풀었다.

n을 3으로 나눈 나머지가 1이면 1, 2면 2, 0이면 4로 대입하고 그 몫을 다시 3으로 나누는 과정을 반복했다.

또한, 3으로 나눠서 나머지가 0일 때 몫은 -1을 해줘야 되는 규칙이 있다.

```
String[] arr = {"4", "1", "2"};

while(n >0) {
  int mod = n % 3;
  for(int i=0; i<3; i++) {
    if(mod == i) {
    answer = arr[i] + answer;
    }
  }
  n = n/3;
  if(mod == 0) n--;
}
```

## 2. 올바른 괄호(CorrectParenthesis.java)

Stack을 이용해 Stack 안에 '('가 들어있고 현재 들어가려는 문자가 ')'일 때 stack에서 '(' 빼는 작업을 반복적으로 하게끔 구현했다.

마지막에 stack이 비어있으면 true, 비어있지 않으면 false를 리턴하도록 했다.

## 3. 프린터(Printer.java)

Printer 클래스에 중요도에 따른 인쇄 순서 order와 내가 인쇄를 요청한 문서인지 아닌지 확인하는 check 변수를 선언하고 location과 같은 위치인 문서만 check 변수에 true값을 저장했다.

count 배열에는 중요도에 따른 인쇄순서를 다 저장하고 오름차순 정렬했다.

ArrayList에 priorities 배열 순서대로 Printer클래스를 넣는 작업을 한 뒤에 count 배열의 인쇄 순서와 ArrayList queue의 인쇄 순서를 비교하며 순서가 같으면 ArrayList에서 삭제하고 순서가 다르면 ArrayList의 마지막으로 가게끔 구현했다.
```
while(queue.size()>0) {
  Printer p = queue.get(0);
  queue.remove(0);
  if(count[idx] == p.order) {
    idx++;
    if(p.check) break;
  } else {
    queue.add(p);
  }
}
```

## 4. 더 맵게(Spicier.java)

PriorityQueue를 이용해서 제일 작은 스코빌 지수와 두번째로 작은 스코빌 지수를 섞는 작업을 하고, 제일 작은 숫자가 K보다 크거나 같아지거나 PriorityQueue의 사이즈가 1보다 작거나 같아지면 while문을 빠져나오도록 구현했다.
```
while(pq.peek() <= K && pq.size() > 1) {
  int num1 = pq.poll();
  int num2 = pq.poll();
  int newNum = num1 + num2*2;
  pq.add(newNum);
  answer++;
}
```