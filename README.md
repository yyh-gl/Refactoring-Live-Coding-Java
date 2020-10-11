
# TDDBC開催されていたリファクタリングのライブコーディング

- [お題『emilybache/GildedRose-Refactoring-Kata』](https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements_jp.md)
- [主催者さんのコミット履歴](https://github.com/nihonbuson/GildedRose-Refactoring-Kata/commits/practice_20200810)


## ブランチ

- `before`：リファクタ前
- `after`：リファクタ後

## メモ

### 最重要事項

<b>リファクタする箇所を限定して、その部分のテストを充実させた（注力した）上で変更を入れていく</b>

### 全体俯瞰大事

流れを把握し、どこをどうのように直せそうか、ここを変更すると危なそうなどなど、ざっくり把握することは大事

### テストtips

- 現状の出力を正としてテストを書く
- カバレッジを出して、どこを通っているのかチェック
  - 影響範囲、修正すべきところが分かる
- リファクタリング箇所のテストに注力する

### リファクタリングtips

- IntelliJの便利機能（他エディタ、IDEにもあるかも）
  - `Extract Method`：関数に切り出し
  - `Refactoring > Introduce Variable`
  - `Refactoring > Introduce Parameter`
  - `Invert 'if' condition`：if文の否定形を肯定形、肯定形を否定形に変換可能
- 「修正に閉じていて、拡張に開いている」

### テストのリファクタリングtips

- テスト名のリファクタリング
- 構造化


### 他の改善案

- 更新処理のメソッドは１つだけにしてもいいかも
  - 両方とも呼び出さないとビジネスルール保てないから
- 上限下限の判断、増減の実行はGildedRoseItemクラスに移管
  - クラスの責務を明確化
- 実装クラスにItemインスタンスをもたせる
  - 実装クラスをFactoryで生成
  - コンストラクタでItemを渡すパターン使うかも
