# About Discord InteraKTions
Originally created by [MrPowerGamerBR](https://github.com/MrPowerGamerBR), Discord InteraKTions was meant to be a light
abstraction on top of the [Kord library](https://github.com/kordlib/kord). However, they have long abandoned the project,
as several issues regarding the battle tested capability of the library has raised several issues. Since our bot,
[Nabi](https://github.com/catgirlclient/nabi), uses Kord under the hood, we used the library and updated it to our
specifications.

Over time, we have added new features, such as JDA support for the library, and have kept the codebase in line with the
two libraries.

Now, Discord InteraKTions is maintained under our organization, as we try to improve the usability of its codebase!

Discord InteraKTions is very barebones in comparison to other Kord/JDA libraries like [Kord Extensions](https://github.com/Kord-Extensions/kord-extensions).
We don't include any extra features that you don't need, as it's up to you to make it! It gives the developer more control
over their code, and how they want the feature to be developed.

## Supported Libraries
Any libraries not mentioned are explicitly not supported, and we have no interest in providing support for such libraries.

| Framework                                 | Support      | Notes                                                                                                                                                                     |
|-------------------------------------------|--------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [JDA](https://github.com/discord-jda/JDA) | Full Support | N/A                                                                                                                                                                       |
| [Kord](https://github.com/kordlib/kord)   | Supported    | Officially supports both Gateway and Webserver interactions. However, keep in mind that Kord's release cycles are incredibly slow, so some features may not be supported. |