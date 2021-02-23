## 1. 크레인 인형뽑기 게임(ClawMachineGame.java)

Stack을 이용해 바구니에 인형을 넣고, 터트리는 행위를 구현했다.

```
if(board[i][value-1] != 0) {
  if(!stack.isEmpty()) {
    if(stack.peek() == board[i][value-1]) {
      stack.pop();
      board[i][value-1] = 0;
      answer++;
      break;
    }
  }
  stack.push(board[i][value-1]);
  board[i][value-1] = 0;
  break;
}
```

answer에는 터지는 횟수를 저장하고 리턴할 때 2는 곱해서 리턴했다.
터지는 횟수 대신 answer += 2; 로 저장해서 리턴하는 방법도 있다.

## 2. 두 개 뽑아서 더하기(TwoNumberSum.java)

두 수를 뽑은 결과를 HashSet에 넣어서 중복을 방지하고, 배열에 넣은 뒤 Arrays.sort()를 이용해 정렬했다.

다른 사람들은 아래 코드로 정렬과 배열로 바꾸는 과정을 구현했다.
```
set.stream().sorted().mapToInt(Integer::intValue).toArray()
```

## 3. 신규 아이디 추천(NewIdRecommend.java)

특정 문자를 제외한 특수문자를 제거하는 작업은 정규식을 사용해서 구현했다.
```
answer = answer.replaceAll("[^a-z0-9-_.]", "");
```

반복되는 문자 제거 작업도 정규식을 사용했다.
```
answer = answer.replaceAll("[.]{2,}", ".");
```

다른 사람의 풀이에서는 첫 문자와 끝 문자가 마침표(.)일때 제거하는 작업도 정규식을 사용했다.
```
answer = answer.replaceAll("^[.]|[.]$","");
```

## 4. 모의고사(MockTest.java)

수포자의 찍는 패턴을 배열에 저장해서 하나씩 비교하는 식으로 구현했다.
```
int[][] pattern = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

for(int i=0; i<3; i++) {
  for(int j=0; j<answers.length; j++) {
    if(answers[j] == pattern[i][count]) {
      answer[i]++;
    }
    count++;
    if(count == pattern[i].length)
      count = 0;
  }
  count = 0;
}
```

최고 점수를 구하는 부분은 원래 반복문으로 구현했지만 Math.max()를 통해 더 간결하게 구현할 수 있어서 수정했다.
```
int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
```

## 5. 3진법 뒤집기(TernaryNotationReverse.java)

10진법을 3진법으로 바꾸는 작업은 while문을 이용해 3으로 나눈 나머지를 list에 넣는 식으로 구현했다.
```
while(n>0) {
  list.add(n%3);
  n = n/3;
}
```

3진법을 뒤집고 10진법으로 바꾸는 작업은 Math.pow() 를 이용해 구현했다.
```
for(int i=list.size()-1; i>=0; i--) {
  answer += Math.pow(3, list.size()-i-1)*list.get(i);
}
```