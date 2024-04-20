### Daemon Thread 和 User Thread 差異
1. Daemon thread 為背景執行緒，User thread 為使用者執行緒
2. Main thread 不會等待 Daemon thread 回傳結果，反之會等待 User thread 回傳結果

### Future 介面
Future 為 java 1.5 提供的異步執行規範介面
![alt Future UML](./images/RunnableFuture.jpg)


### FutureTask 有無取用結果時間差異
無get結果   
![alt 無get結果](./images/FutureTaskNotGetResult.jpg)
有get結果   
![alt 無get結果](./images/FutureTaskGetResult.jpg)


### FutureTask 缺點
1. 當 FutureTask 的 get 先被呼叫時就必須等待返回結果，導致後續動作被阻塞
2. 若使用 isDone + while(true) 隨時判斷是否做完，會導致執行緒空輪詢

### CompletableFuture 針對 FutureTask 的改進
1. 當異步任務計算完成會主動通知完成
2. 可以更詳細的處理異步任務的步驟
