package com.example.verses

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        val emotion = intent.getStringExtra("emotion")
        val emotionTextView = findViewById<TextView>(R.id.emotionTextView)
        val quoteTextView = findViewById<TextView>(R.id.quoteTextView)
        val regenerateButton = findViewById<Button>(R.id.regenerateButton)
        val backButton = findViewById<Button>(R.id.backButton)

        emotionTextView.text = emotion

        fun showRandomQuote() {
            val quotes = quotesByEmotion[emotion] ?: listOf("No quote available.")
            val quote = quotes.random()

            quoteTextView.animate().alpha(0f).setDuration(200).withEndAction {
                quoteTextView.text = quote
                quoteTextView.animate().alpha(1f).setDuration(200).start()
            }.start()
        }

        showRandomQuote()

        regenerateButton.setOnClickListener {
            showRandomQuote()
        }

        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }

    private val quotesByEmotion = mapOf(
        "Sadness" to listOf("Psalm 34:18 — ‘The Lord is close to the brokenhearted and saves those who are crushed in spirit.’",
            "Matthew 5:4 — ‘Blessed are those who mourn, for they will be comforted.’",
            "Revelation 21:4 — ‘He will wipe every tear from their eyes.’",
            "John 16:22 — ‘Now is your time of grief, but I will see you again and you will rejoice.’",
            "Psalm 147:3 — ‘He heals the brokenhearted and binds up their wounds.’",
            "2 Corinthians 1:3-4 — ‘The God of all comfort, who comforts us in all our troubles.’",
            "Isaiah 41:10 — ‘Do not fear, for I am with you; do not be dismayed.’",
            "Psalm 30:5 — ‘Weeping may stay for the night, but rejoicing comes in the morning.’",
            "Romans 8:28 — ‘In all things God works for the good of those who love him.’",
            "Psalm 42:11 — ‘Why, my soul, are you downcast?… Put your hope in God.’",
            "Isaiah 43:2 — ‘When you pass through the waters, I will be with you.’",
            "Psalm 23:4 — ‘Even though I walk through the darkest valley… you are with me.’",
            "Romans 15:13 — ‘May the God of hope fill you with all joy and peace.’",
            "Isaiah 61:3 — ‘To bestow on them a crown of beauty instead of ashes.’",
            "Matthew 11:28 — ‘Come to me, all you who are weary and burdened, and I will give you rest.’"),
        "Anger" to listOf("James 1:19-20 — ‘Everyone should be quick to listen, slow to speak and slow to become angry.’",
            "Proverbs 15:1 — ‘A gentle answer turns away wrath, but a harsh word stirs up anger.’",
            "Ephesians 4:26-27 — ‘In your anger do not sin.’",
            "Proverbs 14:29 — ‘Whoever is patient has great understanding.’",
            "Colossians 3:8 — ‘But now you must also rid yourselves of all such things as these: anger, rage, malice.’",
            "Psalm 37:8-9 — ‘Refrain from anger and turn from wrath.’",
            "Ecclesiastes 7:9 — ‘Do not be quickly provoked in your spirit.’",
            "Proverbs 29:11 — ‘Fools give full vent to their rage, but the wise bring calm.’",
            "Matthew 5:22 — ‘But I tell you that anyone who is angry with a brother or sister will be subject to judgment.’",
            "Romans 12:19 — ‘Do not take revenge… for it is written: “It is mine to avenge.”’",
            "Galatians 5:22-23 — ‘The fruit of the Spirit is love, joy, peace, forbearance… self-control.’",
            "Proverbs 16:32 — ‘Better a patient person than a warrior, one with self-control.’",
            "Psalm 4:4 — ‘Tremble and do not sin; when you are on your beds, search your hearts and be silent.’",
            "Matthew 6:14 — ‘If you forgive other people when they sin against you, your heavenly Father will also forgive you.’",
            "1 Peter 3:9 — ‘Do not repay evil with evil or insult with insult.’"),
        "Fear" to listOf("Isaiah 41:10 — ‘So do not fear, for I am with you; do not be dismayed.’",
            "2 Timothy 1:7 — ‘For God gave us a spirit not of fear but of power and love.’",
            "Joshua 1:9 — ‘Be strong and courageous. Do not be afraid; do not be discouraged.’",
            "Psalm 56:3 — ‘When I am afraid, I put my trust in you.’",
            "Deuteronomy 31:6 — ‘Be strong and courageous… the Lord your God goes with you.’",
            "Psalm 23:4 — ‘Even though I walk through the darkest valley… I will fear no evil.’",
            "1 John 4:18 — ‘There is no fear in love. But perfect love drives out fear.’",
            "Psalm 27:1 — ‘The Lord is my light and my salvation—whom shall I fear?’",
            "Isaiah 43:1 — ‘Do not fear, for I have redeemed you.’",
            "Matthew 10:31 — ‘So don’t be afraid; you are worth more than many sparrows.’",
            "Proverbs 29:25 — ‘Fear of man will prove to be a snare, but whoever trusts in the Lord is kept safe.’",
            "John 14:27 — ‘Peace I leave with you; my peace I give you.’",
            "Romans 8:15 — ‘The Spirit you received does not make you slaves, so that you live in fear again.’",
            "Psalm 46:1 — ‘God is our refuge and strength, an ever-present help in trouble.’",
            "Mark 5:36 — ‘Don’t be afraid; just believe.’"),
        "Anxiety" to listOf("Philippians 4:6-7 — ‘Do not be anxious about anything… the peace of God… will guard your hearts.’",
            "1 Peter 5:7 — ‘Cast all your anxiety on him because he cares for you.’",
            "Matthew 6:34 — ‘Therefore do not worry about tomorrow.’",
            "John 14:27 — ‘Do not let your hearts be troubled and do not be afraid.’",
            "Psalm 94:19 — ‘When anxiety was great within me, your consolation brought me joy.’",
            "Matthew 11:28-30 — ‘Come to me, all you who are weary and burdened, and I will give you rest.’",
            "Proverbs 12:25 — ‘Anxiety weighs down the heart, but a kind word cheers it up.’",
            "Isaiah 26:3 — ‘You will keep in perfect peace those whose minds are steadfast.’",
            "Psalm 55:22 — ‘Cast your cares on the Lord and he will sustain you.’",
            "2 Thessalonians 3:16 — ‘May the Lord of peace himself give you peace at all times.’",
            "Colossians 3:15 — ‘Let the peace of Christ rule in your hearts.’",
            "Isaiah 35:4 — ‘Say to those with fearful hearts, “Be strong, do not fear.”’",
            "Luke 12:25-26 — ‘Who of you by worrying can add a single hour to your life?’",
            "Joshua 1:9 — ‘Do not be afraid; do not be discouraged, for the Lord your God will be with you.’",
            "Romans 15:13 — ‘May the God of hope fill you with all joy and peace.’"),
        "Guilt" to listOf("1 John 1:9 — ‘If we confess our sins, he is faithful and just and will forgive us.’",
            "Psalm 32:5 — ‘I said, “I will confess my transgressions to the Lord.” And you forgave.’",
            "Romans 8:1 — ‘Therefore, there is now no condemnation for those who are in Christ Jesus.’",
            "Isaiah 1:18 — ‘Though your sins are like scarlet, they shall be as white as snow.’",
            "Micah 7:18-19 — ‘You will again have compassion on us… you will hurl all our iniquities into the depths of the sea.’",
            "Psalm 103:12 — ‘As far as the east is from the west, so far has he removed our transgressions.’",
            "Hebrews 10:22 — ‘Let us draw near to God with a sincere heart and with the full assurance.’",
            "2 Corinthians 5:17 — ‘If anyone is in Christ, the new creation has come.’",
            "James 5:16 — ‘Confess your sins to each other and pray for each other so that you may be healed.’",
            "Romans 5:8 — ‘While we were still sinners, Christ died for us.’",
            "Ephesians 1:7 — ‘In him we have redemption… the forgiveness of sins.’",
            "Psalm 51:10 — ‘Create in me a pure heart, O God.’",
            "Titus 3:5 — ‘He saved us, not because of righteous things we had done.’",
            "Jeremiah 31:34 — ‘I will forgive their wickedness and will remember their sins no more.’",
            "John 3:17 — ‘For God did not send his Son… to condemn the world, but to save the world through him.’"),
        "Shame" to listOf("Isaiah 54:4 — ‘Do not be afraid; you will not suffer shame.’",
            "Romans 10:11 — ‘Anyone who trusts in him will never be put to shame.’",
            "Psalm 34:5 — ‘Those who look to him are radiant; their faces are never covered with shame.’",
            "Joel 2:26 — ‘You will have plenty to eat… and you will praise the name of the Lord… never again will my people be shamed.’",
            "1 John 1:9 — ‘If we confess our sins, he is faithful and just and will forgive us.’",
            "Romans 8:1 — ‘Therefore, there is now no condemnation for those who are in Christ Jesus.’",
            "Hebrews 12:2 — ‘For the joy set before him he endured the cross, scorning its shame.’",
            "Micah 7:8 — ‘Though I have fallen, I will rise… the Lord will be my light.’",
            "Psalm 25:3 — ‘No one whose hope is in you will ever be put to shame.’",
            "Zephaniah 3:19 — ‘I will give them praise and honor in every land where they have suffered shame.’",
            "2 Corinthians 5:17 — ‘If anyone is in Christ, the new creation has come.’",
            "Isaiah 61:7 — ‘Instead of your shame you will receive a double portion.’",
            "Proverbs 3:35 — ‘The wise inherit honor, but fools get only shame.’",
            "1 Peter 2:6 — ‘The one who trusts in him will never be put to shame.’",
            "Psalm 31:17 — ‘Let me not be put to shame, Lord, for I have cried out to you.’"),
        "Loneliness" to listOf("Deuteronomy 31:6 — ‘The Lord your God goes with you; he will never leave you nor forsake you.’",
            "Psalm 25:16 — ‘Turn to me and be gracious to me, for I am lonely and afflicted.’",
            "Matthew 28:20 — ‘I am with you always, to the very end of the age.’",
            "Psalm 68:6 — ‘God sets the lonely in families.’",
            "Isaiah 41:10 — ‘So do not fear, for I am with you.’",
            "John 14:18 — ‘I will not leave you as orphans; I will come to you.’",
            "Psalm 147:3 — ‘He heals the brokenhearted and binds up their wounds.’",
            "Romans 8:38-39 — ‘Nothing… will be able to separate us from the love of God.’",
            "1 Peter 5:7 — ‘Cast all your anxiety on him because he cares for you.’",
            "Psalm 139:7-10 — ‘Where can I go from your Spirit?… your hand will guide me.’",
            "Joshua 1:5 — ‘I will never leave you nor forsake you.’",
            "2 Corinthians 1:3-4 — ‘The God of all comfort, who comforts us in all our troubles.’",
            "Zephaniah 3:17 — ‘The Lord your God is with you, the Mighty Warrior who saves.’",
            "Hebrews 13:5 — ‘Never will I leave you; never will I forsake you.’",
            "Psalm 23:4 — ‘Even though I walk through the darkest valley… you are with me.’"),
        "Frustration" to listOf("Galatians 6:9 — ‘Let us not become weary in doing good, for at the proper time we will reap a harvest.’",
            "Proverbs 3:5-6 — ‘Trust in the Lord… and he will make your paths straight.’",
            "Philippians 4:13 — ‘I can do all this through him who gives me strength.’",
            "James 1:4 — ‘Let perseverance finish its work so that you may be mature and complete.’",
            "Romans 5:3-4 — ‘Suffering produces perseverance; perseverance, character; and character, hope.’",
            "Isaiah 40:31 — ‘Those who hope in the Lord will renew their strength.’",
            "Psalm 37:7 — ‘Be still before the Lord and wait patiently for him.’",
            "Ecclesiastes 7:8 — ‘The end of a matter is better than its beginning, and patience is better than pride.’",
            "2 Corinthians 4:8-9 — ‘We are hard pressed on every side, but not crushed.’",
            "Psalm 55:22 — ‘Cast your cares on the Lord and he will sustain you.’",
            "Hebrews 10:36 — ‘You need to persevere so that… you will receive what he has promised.’",
            "Colossians 1:11 — ‘Being strengthened with all power… so that you may have great endurance and patience.’",
            "Psalm 46:10 — ‘Be still, and know that I am God.’",
            "Romans 12:12 — ‘Be joyful in hope, patient in affliction, faithful in prayer.’",
            "James 5:8 — ‘You too, be patient and stand firm, because the Lord’s coming is near.’"),
        "Hopelessness" to listOf("Jeremiah 29:11 — ‘For I know the plans I have for you… plans to give you hope and a future.’",
            "Romans 15:13 — ‘May the God of hope fill you with all joy and peace.’",
            "Psalm 42:11 — ‘Why, my soul, are you downcast?… Put your hope in God.’",
            "Isaiah 40:31 — ‘Those who hope in the Lord will renew their strength.’",
            "Hebrews 10:23 — ‘Let us hold unswervingly to the hope we profess.’",
            "Romans 8:28 — ‘In all things God works for the good of those who love him.’",
            "Lamentations 3:21-23 — ‘His compassions never fail. They are new every morning.’",
            "Psalm 33:18 — ‘The eyes of the Lord are on those who fear him, on those whose hope is in his unfailing love.’",
            "Titus 2:13 — ‘While we wait for the blessed hope—the appearing of… Jesus Christ.’",
            "1 Peter 1:3 — ‘In his great mercy he has given us new birth into a living hope.’",
            "Micah 7:7 — ‘But as for me, I watch in hope for the Lord.’",
            "Zephaniah 3:17 — ‘He will take great delight in you… and rejoice over you with singing.’",
            "Psalm 130:5 — ‘I wait for the Lord, my whole being waits, and in his word I put my hope.’",
            "Job 11:18 — ‘You will be secure, because there is hope.’",
            "Isaiah 61:3 — ‘To bestow on them a crown of beauty instead of ashes.’"),
        "Grief" to listOf("Matthew 5:4 — ‘Blessed are those who mourn, for they will be comforted.’",
            "Psalm 34:18 — ‘The Lord is close to the brokenhearted.’",
            "Revelation 21:4 — ‘He will wipe every tear from their eyes.’",
            "Psalm 147:3 — ‘He heals the brokenhearted and binds up their wounds.’",
            "2 Corinthians 1:3-4 — ‘The God of all comfort, who comforts us in all our troubles.’",
            "John 14:1-3 — ‘Do not let your hearts be troubled.’",
            "1 Thessalonians 4:13-14 — ‘We do not grieve like the rest of mankind, who have no hope.’",
            "Romans 8:18 — ‘Our present sufferings are not worth comparing with the glory that will be revealed.’",
            "Psalm 23:4 — ‘Even though I walk through the darkest valley… you are with me.’",
            "Isaiah 61:1-3 — ‘He has sent me to bind up the brokenhearted.’",
            "Psalm 30:5 — ‘Weeping may stay for the night, but rejoicing comes in the morning.’",
            "Ecclesiastes 3:1,4 — ‘There is a time to weep and a time to laugh, a time to mourn and a time to dance.’",
            "John 11:25 — ‘I am the resurrection and the life.’",
            "Romans 15:13 — ‘May the God of hope fill you with all joy and peace.’",
            "Isaiah 49:13 — ‘The Lord comforts his people and will have compassion on his afflicted ones.’")
    )

}