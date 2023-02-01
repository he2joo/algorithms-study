## 67. Add Binary
https://leetcode.com/problems/add-binary/description/
### 문제설명
이진수 문자열 2개를 입력받아 두 이진수를 더한 이진수 문자열을 출력하는 문제  
```shell
Input : a = "11", b = "1"
Output : "100"
```

### 풀이1
- 간단하게 두 개의 이진수 문자열을 십진수로 변환해서 더한 후에 
다시 이진수 문자열로 변환한다.
```java
int digit_a = Integer.parseInt(a, 2);
int digit_b = Integer.parseInt(b, 2);
```
**NumberFormatException**  
- 입력받는 문자열의 길이는 1 <= 문자열 길이 <= 10^4 여서 int형 범위를 넘어간다.  
- long으로 해도 범위를 넘어간다.
- BigInteger를 사용하면 해결할 수 있다.
```java
BigInteger big_a = new BigInteger(a, 2);
BigInteger big_b = new BigInteger(b, 2);
BigInteger sum = big_a.add(big_b);
return sum.toString(2);
```
### 풀이2
- 두 문자열에서 값을 하나씩 더해서 문자열에 저장하는 방식
1. 문자열의 길이까지의 숫자를 구해서 더한다.
```java
if(a_len > 0){
    sum = a.charAt(a_len-1) - '0';    
    a_len--;
}
if(a_len > 0){
    sum = b.charAt(b.len-1) - '0';
    b_len--;
}
```
2. 두 이진수를 더한 값은 0 or 1 or 2 이고 캐리가 있다면 3이기 때문에 
2로 나눈 나머지를 결과 문자열에 저장하고 몫을 캐리로 사용하면 된다.
```java
result.append(sum%2);
sum /= 2;
```
3. 모든 문자열을 더하고 마지막에 캐리가 있다면 결과 문자열에 더해준다.

## 289. Game of Life
https://leetcode.com/problems/game-of-life/description/
### 문제설명
- 라이프게임이라는 간단한 몇가지 규칙으로 복잡한 패턴을 만들어낼 수 있는 유명한 게임  
  https://cakeandturtles.nfshost.com/games/gameoflife.php
- 무한한 크기의 보드에 세포들이 있는데 live(1)이거나 die(0) 둘 중에 하나의 상태만을 갖는다.
- 각각의 세포는 8개의 이웃을 가진다.
1. live(1) 세포는 2개 보다 적은 live(1) 이웃 세포를 가지면 die(0) 상태로 바뀐다.
2. live(1) 세포는 2개 또는 3개의 live(1) 이웃 세포를 가지면 live(1) 상태를 유지한다.
3. live(1) 세포는 3개 보다 많은 live(1) 이웃 세포를 가지면 die(0) 상태로 바뀐다.
4. die(0) 세포는 3개의 live(1) 이웃 세포를 가지면 live(1) 상태로 바뀐다.
 
![grid1](https://user-images.githubusercontent.com/57559288/215323553-2a45370f-9857-4160-b635-e4cb46282059.jpg)  
- Input으로 m x n 크기의 보드가 주어졌을 때 위 규칙을 만족하는 다음 상태의 보드를 구하는 문제
```
Input : [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output : [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
```
### 풀이1
- 이웃 세포들 중에 1인 세포들의 개수를 구해서 문제의 규칙대로 다음 상태를 구하면 되는 문제이다. 
1. 8개의 이웃 세포를 방향 벡터를 이용해서 구한다.
2. m x n 만큼 보드를 돌면서 1인 이웃 세포의 개수를 구하고 규칙에 맞는 다음 상태를 구한다.
```java
int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

for(int i=0; i<m; i++){
    for(int j=0; j<n; j++){
        int live = 0;
        for(int k=0; k<8; k++){
            int neighbor_x = i + dx[k];
            int neighbor_y = j + dy[k];
            if(neighbor_x >= 0 && neighbor_x < m && neighbor_y >= 0 && neighbor_y < n){
                if(board[neighbor_x][neighbor_y] == 1){
                    live++;
                }
            }
        }
    }
}
```
**고민**  
반복문을 돌면서 세포의 값을 바꾸면 다음 세포의 값을 구할 때 바뀐 이웃 세포의 값으로 구하게 된다.  
↓  
다음 상태를 저장하는 배열을 하나 더 만들어서 값을 저장해서 구했다.  
