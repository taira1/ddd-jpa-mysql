# ddd_jpa_mysql

### コンテナの起動
`docker-compose up`

### コンテナにログイン
`docker exec -it {コンテナ名} bash`

### IntelliJまたはeclipseインストール

### ビルド
`.\gradlew classes`

### レイヤ化
- presentation層  
  ユーザのリクエストを受け付け、レスポンスを返却する層。
  - controller  
    リクエスト/レスポンスのハンドリング、バリデーション実行。
- application層  
  ビジネスロジックのワークフロー制御、トランザクション・セキュリティ制御などを実行する。
  - service  
    ワークフロー、トランザクション管理。簡易なロジックであればこちらで実装。
  - dto  
    DataTransferObject。domain/objectとrequest/responseの橋渡し。
- domain層  
  ビジネスロジック実行箇所。  
  modelクラスはserviceが肥大化する場合や共通化が必要な場合のみ実装。
  - enums  
    key:valueのマッピングオブジェクト
  - object  
    ドメインオブジェクト。
  - object/value  
    DBテーブルと対応するバリューオブジェクト。
  - model  
    データ永続化に関わらず、複数のobjectにまたがるロジックを実行するクラス。    
    serviceのロジックが肥大化する場合に実装。
  - repository  
    DBデータアクセスインターフェース。
- infrastructure層  
  外部データアクセス層。
  - repository  
    CRUD処理呼び出しクラス。  
    Jpaを呼び出しdomain/objectを返却する。  
